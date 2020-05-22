@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ...

    weather = data[position];
    holder.txtTitle.setText(weather.getName());

    if(currentImage.equals("Köp Kurs")){
        holder.imgIcon.setText(Double.toString(weather.getBuyingRate()));
    }
    else if(currentImage.equals("Antal")){
        holder.imgIcon.setText(Double.toString(weather.getNrOfSharesInPortfolio()));
    }
    return row;
}