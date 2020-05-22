@Table(name="ROOMS")
@SecondaryTable(name="TRAINERS", pkJoinColumns={
    @PrimaryKeyJoinColumn(name="TRSC_OOC_UNIT_ID", referencedColumnName="OOC_UNIT_ID"),
    @PrimaryKeyJoinColumn(name="TRSC_OOC_START_DT", referencedColumnName="OOC_START_DT"),
    @PrimaryKeyJoinColumn(name="TRSC_OOC_START_TM", referencedColumnName="OOC_START_TM")
})
public class MyMergedEntity {