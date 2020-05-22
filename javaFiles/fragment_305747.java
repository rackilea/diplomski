@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionData {

    @Id
    @Indexed
    private UUID key;

    private String productId;

    private String receiptString;

    private Date expirationDate;

}