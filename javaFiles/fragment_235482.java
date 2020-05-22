import ij.ImagePlus;
import ij.measure.ResultsTable;
import ij.plugin.filter.ParticleAnalyzer;

[...]

ImagePlus imp = // you have to know how to get your image
ResultsTable rt = new ResultsTable();
Double min_size = 50.0;
Double max_size = Double.POSITIVE_INFINITY;
ParticleAnalyzer pa = new ParticleAnalyzer(ParticleAnalyzer.SHOW_MASKS + ParticleAnalyzer.IN_SITU_SHOW, 0, rt, min_size, max_size);
pa.analyze(imp);