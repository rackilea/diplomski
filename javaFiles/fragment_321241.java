for (int i = 1; i < 10; i++){
                String str = "weblinks_" + i;
                try {
                    details =this.getResources().getIdentifier(str, "array", this.getPackageName());

                    typedArray = getResources().obtainTypedArray(details);
                    for (int k = 0; k < typedArray.length(); k++) {
                        MenuItem = typedArray.getString(k);
                        if (k == 0) {
                            Log.e("String from" + str,MenuItem);
                        }
                    }
                } catch (Resources.NotFoundException e) {

                }


            }