public void StartActivityForImages(Context context, int i){

    switch (i){
        case 0:
            Intent Intent = new Intent(context, Image0.class);
            context.startActivity(Intent);
            break;

        case 1:
            Intent Intent2 = new Intent(context, Image1.class);
            context.startActivity(Intent2);
            break;
        case 2:
            Intent Intent3 = new Intent(context, Image3.class);
            context.startActivity(Intent3);
            break;

        ......
    }

}