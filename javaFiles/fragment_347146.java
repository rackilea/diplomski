final HashMap<Integer, Integer> pMap = new HashMap<Integer, Integer>();
final HashMap<Integer, String> nameMap = new HashMap<Integer, String>();
final HashMap<Integer, Destination> objectMap = new LinkedHashMap<Integer, Destination>();

/**
 * get the data from cloud database
 */
BmobQuery<Destination> query = new BmobQuery<Destination>();

// this time only one list of three elements is added instead of three lists of one element each
query.addWhereContainedIn("id", Arrays.asList(selectedID));

query.findObjects(new FindListener<Destination>() {
                @Override
                public void done(List<Destination> list, BmobException e) {
                    if (e == null) {
                        System.out.println("success：total" + list.size() + "items。");
                        for (Destination destination : list) {

                            int p = destination.getPriority();

                            int id = destination.getId();

                            String name = destination.getName();


                            double longitude = destination.getLongitude();
                            double latitude = destination.getLatitude();

                            objectMap.put(id, new Destination(longitude, latitude));

                            System.out.println(id);

                            //calculate the distance
                            double dis = DistanceUtil.distance(start.getLongitude(), start.getLatitude(),
                                    longitude, latitude);

                            pMap.put(id, p);
                            weightMap.put(id, new Double(dis));
                            nameMap.put(id, name);

                        }
                        // continue execution here though you won't be able to return a list of plans here
                    } else {
                        Log.i("bmob", "error：" + e.getMessage() + "," + e.getErrorCode());
                    }
                }
});