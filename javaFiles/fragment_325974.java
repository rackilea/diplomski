public void imageViewBiljeskeNaListiCheckMarkMetoda(View view){
        flag =!flag;

        if (view == imageViewBiljeskeNaListiCheckMark){
          if (flag) {imageViewBiljeskeNaListiCheckMark.setImageResource(R.drawable.ic_biljeske_obavljeno);
        } else {
            imageViewBiljeskeNaListiCheckMark.setImageResource(R.drawable.ic_biljeske_nije_obavljeno);
        } 
}