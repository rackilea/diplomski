class HotelPromotionList {
   List<HotelPromotion> hotelPromotions;
}

class HotelPromotion {
   int id;
   int version;
   String description;
   String status; // might be an enum
   // ...
}