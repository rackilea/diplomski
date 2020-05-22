public class DatasetPairVisualization {

    ...

    @ManyToOne
    @JoinColumn(name = "dataset_1_fk")
    private Dataset dataset1;

    @ManyToOne
    @JoinColumn(name = "dataset_2_fk")
    private Dataset dataset2;

    ...