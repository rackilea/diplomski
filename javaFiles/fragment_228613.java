View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflate_common_item, viewGroup, false);
ViewHolder holder= new ViewHolder(mView);
if(Manual_color)
{
   //Row BackgroundColor to red.
   Manual_color = false;
}
else
{
  //Row BackgroundColor to Green.
  Manual_color = true;
}
return holder;