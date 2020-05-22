package foldingcomponentsdemo;

import static foldingcomponentsdemo.Constants.BLOCK_COLOR_BG;
import static foldingcomponentsdemo.Constants.BLOCK_H;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_BG_COLOR;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_BORDER_COLOR;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_FG_COLOR;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_H;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_LABEL_FG_COLOR;
import static foldingcomponentsdemo.Constants.BLOCK_HEADER_LABEL_FONT_SIZE;
import static foldingcomponentsdemo.Constants.BUTTON_FOLD_COLOR_BG;
import static foldingcomponentsdemo.Constants.BUTTON_FOLD_COLOR_BG_DOWN;
import static foldingcomponentsdemo.Constants.BUTTON_FOLD_COLOR_BG_OVER;
import static foldingcomponentsdemo.Constants.BUTTON_WH;
import static foldingcomponentsdemo.Constants.GAP;
import static foldingcomponentsdemo.Constants.INNER_W;
import static foldingcomponentsdemo.Constants.LABEL_TEXT;
import static foldingcomponentsdemo.Constants.MAINWINDOW_H;
import static foldingcomponentsdemo.Constants.MAINWINDOW_W;
import static foldingcomponentsdemo.Constants.MARGIN;
import static foldingcomponentsdemo.Constants.NUMBER_OF_BLOCKS;
import static foldingcomponentsdemo.FoldingComponentsDemo.getScene;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

class Constants {

    public static final int MARGIN = 2;
    public static final int BLOCK_H = 100;
    public static final int NUMBER_OF_BLOCKS = 5;
    public static final int SCROLLER_HOR_WIDTH = 26;
    public static final int MAINWINDOW_W = 300;
    public static final int MAINWINDOW_H = BLOCK_H * (NUMBER_OF_BLOCKS - 2);
    public static final int INNER_W = MAINWINDOW_W - SCROLLER_HOR_WIDTH;
    public static final int BLOCK_HEADER_H = 20;
    public static final int BUTTON_WH = BLOCK_HEADER_H - (MARGIN * 2);
    public static final int BLOCK_HEADER_LABEL_FONT_SIZE = 11;
    public static final Color BLOCK_HEADER_BG_COLOR = Color.decode("#000000");
    public static final Color BLOCK_HEADER_FG_COLOR = Color.decode("#cccccc");
    public static final Color BLOCK_HEADER_BORDER_COLOR = Color.decode("#777777");
    public static final Color BUTTON_FOLD_COLOR_BG = Color.decode("#ff0000");
    public static final Color BUTTON_FOLD_COLOR_BG_OVER = Color.decode("#999999");
    public static final Color BUTTON_FOLD_COLOR_BG_DOWN = Color.decode("#cccccc");
    public static final Color BLOCK_COLOR_BG = Color.decode("#555555");
    public static final Color BLOCK_HEADER_LABEL_FG_COLOR = Color.decode("#ffffff");
    public static final String GAP = " ";
    public static final String LABEL_TEXT = "click red button on right to (un)fold";

}

public class FoldingComponentsDemo {

    private static Block block;
    private static final FoldingContainer SCENE = new FoldingContainer();
    private static final JScrollPane SCROLLER = new JScrollPane(SCENE);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
    }

    private static void createGUI() {

        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            block = new Block("BLOCK_" + i, INNER_W, BLOCK_H);
            SCENE.add(block);
        }

        JFrame frame = new JFrame("Folding components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(SCROLLER);
        frame.setSize(MAINWINDOW_W, MAINWINDOW_H);
        frame.setVisible(true);
    }

    public static FoldingContainer getScene() {
        return SCENE;
    }
}

class Block extends JPanel {

    private static Dimension BLOCK_SIZE;
    public boolean isFolded;

    public Block(String name, int innerW, int blockHeight) {

        this.isFolded = false;
        BLOCK_SIZE = new Dimension((int) innerW, blockHeight);

        setName(name);
        setLayout(null);
        setPreferredSize(BLOCK_SIZE);
        setMinimumSize(BLOCK_SIZE);
        setMaximumSize(BLOCK_SIZE);
        setBackground(BLOCK_COLOR_BG);
        setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        add(new Header());
    }
}

class Label extends JLabel {

    public Label(String text, int innerW) {

        setText(text);
        setSize(innerW, BLOCK_HEADER_H);
        setForeground(BLOCK_HEADER_LABEL_FG_COLOR);
        setFont(new Font("Tahoma", Font.PLAIN, BLOCK_HEADER_LABEL_FONT_SIZE));
    }
}

class Header extends JPanel {

    public Header() {
        setLayout(null);
        setSize(INNER_W, BLOCK_HEADER_H);
        setBackground(BLOCK_HEADER_BG_COLOR);
        setForeground(BLOCK_HEADER_FG_COLOR);
        setBorder(BorderFactory.createLineBorder(BLOCK_HEADER_BORDER_COLOR, 1, false));

        add(new Label(GAP + LABEL_TEXT, INNER_W));

        JButton BUTTON_FOLD = new JButton();
        BUTTON_FOLD.setBounds(INNER_W - (BUTTON_WH * 2), MARGIN, BUTTON_WH, BUTTON_WH);
        BUTTON_FOLD.setMargin(new Insets(0, 0, 0, 0));
        BUTTON_FOLD.setFocusPainted(false);
        BUTTON_FOLD.setBackground(BUTTON_FOLD_COLOR_BG);
        BUTTON_FOLD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BUTTON_FOLD.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                BUTTON_FOLD.setBackground(BUTTON_FOLD_COLOR_BG_OVER);
            }

            public void mouseExited(MouseEvent e) {
                BUTTON_FOLD.setBackground(BUTTON_FOLD_COLOR_BG);
            }

            public void mousePressed(MouseEvent e) {
                BUTTON_FOLD.setBackground(BUTTON_FOLD_COLOR_BG_DOWN);
            }

            public void mouseClicked(MouseEvent e) {
                BUTTON_FOLD.setBackground(BUTTON_FOLD_COLOR_BG_DOWN);
                Block blck = (Block) BUTTON_FOLD.getParent().getParent();
                blck.isFolded = !blck.isFolded;
                ((FoldingLayout) getScene().getLayout()).setExpanded(blck);
            }
        });

        add(BUTTON_FOLD);
    }
}

class FoldingContainer extends JPanel {

    FoldingLayout layout;

    public FoldingContainer() {
        setName("Folding container");
        layout = new FoldingLayout();
        setLayout(layout);
    }
}

class FoldingLayout implements LayoutManager {

    private Component block;
    private String initialised;

    public void setExpanded(Component BLOCK) {
        this.block = BLOCK;
        this.initialised = "yes";
        layoutContainer(block.getParent());
    }

    public Component getExpanded() {
        return block;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container cont) {
        return minimumLayoutSize(cont);
    }

    @Override
    public Dimension minimumLayoutSize(Container cont) {
        int width = INNER_W;
        int height = 0;
        for (Component comp : cont.getComponents()) {
            height += comp.getHeight();
        }
        return new Dimension(width, height);
    }

    @Override
    public void layoutContainer(Container cont) {
        Insets insets = cont.getInsets();
        int x = insets.left;
        int y = insets.top;

        for (Component comp : cont.getComponents()) {
            if (initialised == null) {
                comp.setSize(comp.getMinimumSize().width, comp.getMinimumSize().height);
            } else {
                if (((Block) comp).isFolded) {
                    comp.setSize(comp.getMinimumSize().width, BLOCK_HEADER_H);
                } else {
                    comp.setSize(comp.getMinimumSize().width, comp.getMinimumSize().height);
                }
            }
            comp.setLocation(x, y);
            y += comp.getHeight();
        }

        // update for scroller
        cont.getParent().revalidate();
    }
}