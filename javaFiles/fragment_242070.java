List<Observable<HotelInfo>> hotels = new ArrayList<>();
for (URL u : urls) {
    Observable<HotelInfo> hotelInfo = networkAPI.askHotel(u);
    hotels.add(hotelInfo);
}
Observable.merge(hotels)
.filter(h -> h.vacancy > 0)
.take(1)
.subscribe(h -> System.out.println("Winner: " + h), Throwable::printStackTrace);