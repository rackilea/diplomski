@SuppressWarnings("rawtypes")
@Override
public Map getCurrentState() {
  HashMap<String, Object> hashMap = new HashMap<String, Object>();
  hashMap.put(ID, ID);
  hashMap.put(DRAWING_CLOSE_STATE, Boolean.TRUE);
  hashMap.put(DRAWING_SAVE_STATE, Boolean.FALSE);
  hashMap.put(DRAWING_SAVEAS_STATE, Boolean.FALSE);
  return hashMap;
}