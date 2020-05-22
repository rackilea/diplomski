if (position==0) {
        holder.perubahan.setText("0");
} else {
        double inuNilai0 = listData.get(position-1).getInuNilai();
        double inuNilai1 = listData.get(position).getInuNilai();
        double result = inuNilai1-inuNilai0;
        holder.perubahan.setText(String.valueOf(result);
}