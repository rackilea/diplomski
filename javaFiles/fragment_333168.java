public class Band {
    private int totalAlbums;
    private Album[] albums;
    private int currentNumberOfAlbums;

    public Band(int totalAlbums) {
        this.totalAlbums = totalAlbums;
        this.albums = new Album[totalAlbums];
        this.currentNumberOfAlbums = 0;
    }

    public Band(Album[] albums) {
       this.totalAlbums = albums.length;
       this.albums = albums;
       this.currentNumberOfAlbums = this.totalAlbums;
    }

    public void addNewAlbum(String titulo, int temas, int ano) {
        if (this.currentNumberOfAlbums == totalAlbums) {
            System.out.println("Warning: Cannot add any more albums, limit reached.");
            return;
        }
        this.albums[this.currentNumberOfAlbums++] = new Album(titulo, temas, ano);

    }

   public void printAlbums() {
       for (Album a : this.albums) {
           a.mostraAlbum();
       }
   }

    public static void main(String [] args) {
        Band b = new Band(3);
        b.addNewAlbum("The First", 4, 2001);
        b.addNewAlbum("The Second", 98, 2055);
        b.addNewAlbum("The Finale", 12, 2011);
        b.addNewAlbum("The Extra", 12, 2111);

        b.printAlbums();
    }
}