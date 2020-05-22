@Entity
@Table(name = "table_a")
@GenericGenerator(name = "MyProject_Sequence_Generator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
        @Parameter(name = TableGenerator.TABLE_PARAM, value = "table_primary_key_lookup"),
        @Parameter(name = TableGenerator.VALUE_COLUMN_PARAM, value = "next_obj_id"),
        @Parameter(name = TableGenerator.SEGMENT_COLUMN_PARAM, value = "table_name"),
        @Parameter(name = TableGenerator.OPT_PARAM, value = OptimizerFactory.POOL),
        @Parameter(name = TableGenerator.INITIAL_PARAM, value = "1"),
        @Parameter(name = TableGenerator.INCREMENT_PARAM, value = "1"),
        @Parameter(name = TableGenerator.CONFIG_PREFER_SEGMENT_PER_ENTITY, value = "true") })
public class TableAModel {
}