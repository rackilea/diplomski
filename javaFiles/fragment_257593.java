if(checked[position])
    mHolder.check.setVisibility(View.VISIBLE);
else
    mHolder.check.setVisibility(View.INVISIBLE);

mHolder.view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (checked[position]) {
       checked[position] = false;
      } else {
       checked[position] = true;
      }

      // Just add notify. Remove the show/hide code. 
      notifyDataSetChanged();
    }
});