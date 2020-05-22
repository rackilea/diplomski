if (youngestDate != null && oldestDate != null) {
                if (i == 0 || youngestDate.equals(gpsDtoList.get(i).getEreigniszeit())) {
                    properties.put("markerStyle", LATEST);
                } else if (oldestDate.equals(gpsDtoList.get(i).getEreigniszeit())) {
                    properties.put("markerStyle", OLDEST);
                }

            }