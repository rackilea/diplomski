List<Xcatentattr> xcatentAttrList = (List<Xcatentattr>) proce1.get(0);

solrItemVO.setMapPrice(-1); // setting default value

for(Xcatentattr  xcatentattr : xcatentAttrList){

    if(xcatentattr.get(0) == 33)

            solrItemVO.setMapPrice(xcatentattr.get(1));

            solrItemVO.setMapPriceVal(xcatentattr.get(2));

    }
}