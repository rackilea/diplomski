if (savedInstanceState != null){
        selectedPosition=savedInstanceState.getInt("fragmentposition",0);
        selectItem(selectedPosition);
    } else { 
        selectItem(selectedPosition);
    }