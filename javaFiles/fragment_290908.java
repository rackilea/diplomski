Context context;
Private AsyncInterface asyncInterface;

AsyncClassConstructor(Context context){
    this.context = context;
    this.asyncInterface = (AsyncInterface) context;
}