package de.scrum_master.app;

import com.amazon.carbonado.Nullable;
import com.amazon.carbonado.PrimaryKey;
import com.amazon.carbonado.Storable;

@PrimaryKey("ID")
public interface StoredMessage extends Storable<StoredMessage> {
  long getID();
  void setID(long id);
  @Nullable String getMessage();
  void setMessage(String message);
}