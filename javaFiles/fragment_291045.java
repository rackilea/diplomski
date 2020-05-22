echo "Checking files in ${SOURCE_ROOT}"
CPD_DIR=${PROJECT_DIR}/CPD
JARS_DIR=${PROJECT_DIR}/CPD
FULL_PATH_TO_CPD_XML_OUTPUT=${PROJECT_DIR}/cpd-output.xml
OBJC_JAR_LIBRARY=${JARS_DIR}/ObjCLanguage-0.0.5-SNAPSHOT.jar

echo [DEBUG] CPD_DIR = ${CPD_DIR}
echo [DEBUG] JARS_DIR = ${JARS_DIR}
echo [DEBUG] FULL_PATH_TO_CPD_XML_OUTPUT = ${FULL_PATH_TO_CPD_XML_OUTPUT}
echo [DEBUG] OBJC_JAR_LIBRARY = ${OBJC_JAR_LIBRARY}
echo [DEBUG] SOURCE_ROOT = ${SOURCE_ROOT}

# Running CPD
java -classpath "${OBJC_JAR_LIBRARY}:${JARS_DIR}/pmd.jar" net.sourceforge.pmd.cpd.CPD --minimum-tokens 200 --files "${SOURCE_ROOT}" -v --language ObjectiveC --encoding UTF-8 --format net.sourceforge.pmd.cpd.XMLRenderer > "${FULL_PATH_TO_CPD_XML_OUTPUT}"

CPD_EXECUTABLE="${CPD_DIR}/CPDObjective-C"
if [ ! -f "${CPD_EXECUTABLE}" ];
then
echo "CPD executable file is not found: " ${CPD_EXECUTABLE}
fi
echo "Running ${CPD_EXECUTABLE} -cpd-xml ${FULL_PATH_TO_CPD_XML_OUTPUT}"
"${CPD_EXECUTABLE}" -cpd-xml "${FULL_PATH_TO_CPD_XML_OUTPUT}"