GridLayout grid = (GridLayout)findViewById(R.id.grid);
        for(int i=0; i<grid.getChildCount(); i++){
            System.out.println(grid.getColumnCount());
            LinearLayout ll = (LinearLayout) grid.getChildAt(i);
            for(int k=0; k<ll.getChildCount(); k++){
                System.out.println(ll.getChildAt(k));
                ((ImageView) ll.getChildAt(k)).setImageResource(0);