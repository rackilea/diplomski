@Data
@RequiredArgsConstructor
public class DataProduct {
  private List<Product> data;
  private DataProductMetadata meta;
}

@Builder
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class DataProductMetadata {
   @NonNull
   private String store;
   @NonNull
   private Date originated;
   @NonNull
   private String correlationId;
}

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Product {
   @NonNull
   private String barcode;
   @NonNull
   private String description;
   @NonNull
   private Double price;
   @NonNull
   private Double onHand;

  @JsonIgnore
   @JsonUnwrapped
   private Map<String, Object> customFields =new HashMap<>();;

   @JsonAnyGetter
   public Map<String, Object> getCustomFields() {
      return customFields;
   }

   @JsonAnySetter
   public void setCustomField(String name, Object value) {
      customFields.put(name, value);
   }
}