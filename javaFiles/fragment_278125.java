Bottles o = new Bottles();
            o.setbottleID(bottleIntMap.get("bottleID"+i));
            o.setname_abbr(bottleNamesMap.get("name"+i));
            o.setorigin(bottleNamesMap.get("origin"+i));
            o.setbottlePicture(bottleNamesMap.get("bottlePicture"+i));
            o.setprice_reported(bottleNamesMap.get("price"+i));
            o.setdistillery(bottleNamesMap.get("distillery"+i));
            o.setagg_score(bottleIntMap.get("aggscore"+i));
            m_bottles.add(o);