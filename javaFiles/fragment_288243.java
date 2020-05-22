NEXUS_BASE_URL=https://nexus.example.com
REPOSITORY="reponame"
GROUP_ID="groupid"
ARTIFACT_ID="artifact_id"
LOCAL_FILE="destination.jar"

NEXUS_RESOLVE_URL="${NEXUS_BASE_URL}artifact/maven/resolve?g=${GROUP_ID}a=${ARTIFACT_ID}&r=${REPOSITORY}&v=${VERSION}"
REPOSITORY_LOCAL_PATH=`curl -s "${NEXUS_RESOLVE_URL}" | xmllint --xpath "//artifact-resolution/data/repositoryPath/text()" -`
ARTIFACT_DOWNLOAD_URL="${NEXUS_BASE_URL}repositories/${REPOSITORY}/content${REPOSITORY_LOCAL_PATH}"
curl -o "${LOCAL_FILE}" "${ARTIFACT_DOWNLOAD_URL}"