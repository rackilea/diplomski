Context context = v.getContext();
Intent intent = new Intent(context, DetailActivityAnnouncement.class);
intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());

// putExtra can be used to send data with intent, here "date"
// and "title" is key that we will need later to access these values 
intent.putExtra("date",announcementList.get(getAdapterPosition()).getDate());
intent.putExtra("title", announcementList.get(getAdapterPosition()).getTitle());

context.startActivity(intent);