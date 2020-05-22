private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();

@PostConstruct
public void init() {
    for (int id : selectedSessionUI.getSessionInventories()) {
        checked.put(Long.valueOf(id), true);
    }
}

public Map<Long, Boolean> getChecked() {
    return checked;
}