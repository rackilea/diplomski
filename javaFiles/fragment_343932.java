roomTOs.sort(Comparator
            .comparing(
                    personTO::getPersonName)
            .thenComparing(
                    personTO::getUsedDate, Comparator.nullsLast(Comparator.naturalOrder()))
            );