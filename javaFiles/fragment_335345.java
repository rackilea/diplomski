@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

   // get single Message object from ArrayList
   Message mes = messageList.get(position);  // notice the difference 

   // just assuming that you've getter methods in your Message class 
   // please look into your code
   holder.message.setText(mes.getMessage());
   holder.author.setText(mes.getAuthor());
}