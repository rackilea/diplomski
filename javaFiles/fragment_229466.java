@Table("key_card")
public final class KeyCard {

  @JsonView(Views.OnlyOnSerialize.class)
  private String username;

  @JsonView(Views.AlwaysInclude.class)
  @NotBlank
  private final char[] password;
}