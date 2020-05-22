private static final int MAX_ARRAY = 100;
public kids(){
    this.id = new int[MAX_ARRAY];
    this.name = new String[MAX_ARRAY];
    this.user_id= new int[MAX_ARRAY];
    for (int x=0; x<MAX_ARRAY; x++){
        this.id[x]=0;
        this.name[x]="";
        this.user_id[x]=0;
    }
}