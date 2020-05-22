mAdapter = new MyAdapter(new MyAdapter.RecyclerViewItemClick() {

        @Override
        public void OnItemClickListener(PickMemberAdapter.UsersViewHolders holder, int position) {

            String userKey = mUserKey.get(position);

            if (!holder.mCheckBox.isChecked()) {
                holder.mCheckBox.setChecked(true);

                Toast.makeText(MainActivity.this, userKey, Toast.LENGTH_LONG).show();
            } else {
                holder.mCheckBox.setChecked(false);
                Toast.makeText(MainActivity.this, userKey, Toast.LENGTH_LONG).show();
            }

        }

    });