galleryAdater.setOnRadioItemClick(new GalleryAdater.onRadioItemClick() {
        @Override
        public void onCheck(String str) {
            stringsList.set(strings.indexOf(str),"1");
            galleryAdater.notifyDataSetChanged();

        }
    });