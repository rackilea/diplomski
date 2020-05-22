public class PhotoImage extends Image {

    Texture tex;

    public PhotoImage(Texture tex){
        super(tex);
        this.tex = tex;
    }

    public void dispose(){
        try {
            this.tex.dispose();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}