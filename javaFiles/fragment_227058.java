public class Collection {


public  Album collection[]= new Album[10]; 

private int numAlbums = 0;

public void Add (Album a){

    if (numAlbums >= collection.length){

        Album newcollection[]= new Album [collection.length * 2];

        for (int n = 0; n < numAlbums; n ++){

            newcollection[n] = collection[n];
        }

        newcollection = collection;

    }     

    collection[numAlbums] = a;

    numAlbums = numAlbums + 1;

}

public String toString()
{
     String details = "";

            for ( int p = 0; p < numAlbums ; p ++)

            {
                details = details + collection[p] +  "\n" ;

                }

            details += "\n";         

     return details;         
}
public void sort(){
    for(int i=0;i<numAlbums;i++){
        for(int j=i;j<numAlbums-1;j++){
            if(collection[j].compareTo(collection[j+1])>0){
                Album tmp =collection[j];
                collection[j]=collection[j+1];
                collection[j+1]=tmp;
            }
        }
    }
}