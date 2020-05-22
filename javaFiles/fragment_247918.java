case 8:
                    name = "url";
                    break;

                default:
                    //name = "_id";
                    break;
            }

            if(name != null && !name.isEmpty()) {
                cv.put(name, result);
            }

        }

        db.insert("menuTable", null, cv);
    }
}