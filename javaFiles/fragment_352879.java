@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@SuppressWarnings("all")
public class MagazinePostDTO {

    @JsonDeserialize(contentUsing = RelatedDeserializer.class)
    private List<MagazineRelatedDTO> related;
    // other properties....

}