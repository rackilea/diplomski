object MyUtils {
  val dtFormatter = DateTimeFormatter.ofPattern("<some non-ISO pattern>")
}

import MyUtils._
logs.flatMap(fileContent => {
  // can safely use formatter here
})