contactImageImgView.setOnClickListener(new View.OnClickListener) //error @.setOnClickListener Cannot resolve symbol
{
    public void onClick (View v){  // error @ View v, cannot resolve symbol v , expected ;
    Intent intent = new Intent();
    intent.setType("image*/");
    intent.setAction(intent.ACTION_GET_CONTENT);
    startActivityForResult(intent.createChooser(intent, "Select Profile Image"), 1);
    }
}