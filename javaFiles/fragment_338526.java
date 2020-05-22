Map mOffers= new HashMap();
mOffers.put("ofert1", true);
mOffers.put("ofert2", true);
Map mCardNumbers= new HashMap();
mCardNumbers.put("45672224", mOffers);

mDatabase.child("Locales").child(uid).setValue(mCardNumbers);