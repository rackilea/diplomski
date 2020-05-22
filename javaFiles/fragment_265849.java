public override View GetView(int position, View convertView,ViewGroup parent)
        {
          DataViewHolder holder = null;
          Button ExtraBtn ;
            if (convertView == null)
            {
                convertView = LayoutInflater.From(mContext).Inflate(Resource.Layout.InventoryPreview, null, false);
                 holder = new DataViewHolder();
                 holder.txtInventoryID = convertView.FindViewById<TextView>(Resource.Id.txtInventoryID);         
                 holder.txtInventoryName = convertView.FindViewById<TextView>(Resource.Id.txtInventoryName);   
                 holder.txtInventoryPrice = convertView.FindViewById<TextView>(Resource.Id.txtInventoryPrice);
                 ExtraBtn = convertView.FindViewById<Button>(Resource.Id.ExtrasBtn);
                 ExtraBtn.Click += (sender, e) => {
                    // Perform action on click
                   }; 
                    convertView.Tag = holder;
                  ExtraBtn.Tag = position;
            } else {
                ExtraBtn = convertView.FindViewById<ImageView>(Resource.Id.lr_deleteBtn);
                 holder = convertView.Tag as DataViewHolder;
                 ExtraBtn.Tag = position;
            }
           convertView.SetBackgroundColor(GetColorFromInteger(mAlternatingColors[position % mAlternatingColors.Length]));
           holder.txtInventoryID.Text = mitems[position].InventoryItemID;
           holder.txtInventoryName.Text = mitems[position].InventoryItemName;
           holder.txtInventoryPrice.Text = mitems[position].InventoryItemPrice.Replace(",", ".");

            return convertView;

        }

     public class DataViewHolder : Java.Lang.Object
{
    public TextView txtInventoryID { get; set; }
    public TextView txtInventoryName { get; set; }
    public TextView txtInventoryPrice { get; set; }
}