propfiles='./props/default.properties'

args=(-cp 'lib/*')
args+=(-Xmx10G -Duser.timezone=GMT)
args+=("-Danl.property.files=$propfiles")

java "${args[@]}" main.class.path.Main