DateFormat sdf = new SimpleDateFormat("hh:mm");

shipments.sort(Comparator.comparing(
                   Shipments::getShipmentinpickingtime, 
                   Comparator.nullsLast(Comparator.comparing(time -> {
                       try {
                           if (!"null".equals(time) && !StringUtils.isEmpty(time)) {
                               return sdf.parse(time);
                           }
                       } catch (ParseException ignoe) {
                           // Not a valid time
                       }
                       return null;
                   })))
              );