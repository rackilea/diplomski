// Title:
TextView title_text = (TextView) item_view_second.findViewById(R.id.item_title);
if(position == 0){
        title_text.setVisibility(View.VISIBLE);
        title_text.setText(Html.fromHtml(current_post.get_title()));
}
else{
        title_text.setVisibility(View.GONE);
}