public ImageView getCardView(String Card){

        ImageView imageView = new ImageView(this);

        switch(Card){
            case "joker-one": 
                imageView.setImageResource(R.drawable.jokerone);
                imageView.setMaxHeight(20);
                imageView.setMaxWidth(10);
                imageView.setId(1);

            break; 

            default: 
                imageView.setImageResource(R.drawable.kingdiamonds);
                imageView.setMaxHeight(20);
                imageView.setMaxWidth(10);
                imageView.setId(2);
            break; 
        } 

        return imageView;
    }