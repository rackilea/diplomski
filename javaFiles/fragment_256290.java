import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class OpenGLImageTest {

    private static Texture tex; //private static int textureID;

    public static void main(String[] args) throws Exception {
        Display.setTitle("OpenGL Image Test");
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.create();

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 640, 0, 480, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        tex = loadTexture("textures/font.png"); //textureID = bindTextureFile("textures/font.png");

        while (!Display.isCloseRequested()) {
            Display.sync(60);

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glClearColor(0, 0, 0, 1);

            GL11.glColor4f(1, 1, 1, 1);
            drawFontAtlas(0, 0);

            Display.update();
        }

        Display.destroy();
    }

    private static void drawFontAtlas(int x, int y) {
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);

        tex.bind(); //GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
        GL11.glBegin(GL11.GL_QUADS);
        {
            GL11.glTexCoord2f(0, 1); // added texture coordinate
            GL11.glVertex2i(0, 0);
            GL11.glTexCoord2f(0, 0); // added texture coordinate
            GL11.glVertex2i(0, 256);
            GL11.glTexCoord2f(1, 0); // added texture coordinate
            GL11.glVertex2i(256, 256);
            GL11.glTexCoord2f(1, 1); // added texture coordinate
            GL11.glVertex2i(256, 0);
        }
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }

    public static Texture loadTexture(String texturePath) {
        try {
            return TextureLoader.getTexture("png", new FileInputStream(new File(texturePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}