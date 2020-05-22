mkdir lib/expanded
cd lib/expanded
for J in ../*.jar; do
    unzip "${J}"
    rm -rf META-INF
done
zip -R ../../myProject.jar *
cd .. && rm -rf expanded