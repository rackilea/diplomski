return Optional.ofNullable("test") // your fileName
            .filter(x -> !x.contains(" "))
            .map(x -> x.substring(0, x.lastIndexOf(".")))
            .map(x -> x.split("_"))
            .filter(arr -> arr.length == 4)
            .filter(arr -> !arr[1].matches("0*"))
            .filter(arr -> arr[3].equals("PASS") || arr[3].equals("FAIL"))
            .isPresent();