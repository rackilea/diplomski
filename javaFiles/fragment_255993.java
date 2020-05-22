for(int j=0;j<garments.get(i).getSizes().size();j++) {
    bySize = garments.get(i).getSizes().get(j);
    for (Size s : Size.values()) {
        if (bySize.get(s) > 0)  {
            garmentString.append(garmentSizes(i, s, bySize.get(s)));
        }
    }
}