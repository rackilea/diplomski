Map<Integer, Music> musicMap = new HashMap<Integer, Music>();

// To put a new item in the Map
int max = 0;
for (Integer mapCode : musicMap.keySet()) {
    if (mapCode > max) {
        max = mapCode;
    }
}

int newCode = max++;
musicItem.setCode(newCode);
musicMap.put(newCode, musicItem);

// To remove an item by its value
musicMap.remove(code);