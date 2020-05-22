@Override
public int getItemViewType (int position) {
    // position 0 return header type
    if(position == 0) {

        return View_Header;

    }else  {

        return View_Item;
    }

}