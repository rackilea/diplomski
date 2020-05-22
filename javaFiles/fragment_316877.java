al_menu.size() // it always give you size of folder, 

al_menu.get(int_position).getAl_imagepath().size(); 

// passing the folder position so that correct folder images are to be shown.
public TouchImageAdapter(Context context,ArrayList<Model_images> al_menu, int position){
        this.al_menu = al_menu;
        this.context = context;
        this.int_position = position;
    }

    @Override
    public int getCount() {
        return al_menu.get(int_position).getAl_imagepath().size();
    }